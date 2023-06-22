import boto3
import csv
import logging
import psycopg2 as db

# Set up logging
logger = logging.getLogger()
logger.setLevel(logging.INFO)

logger.info("connecting to database")


def lambda_handler(event, context):
    # Replace 'YOUR_S3_BUCKET_NAME' with your S3 bucket name
    s3_bucket_name = 'pharmacy-master-data'
    # Replace 'YOUR_RDS_HOST' with your RDS instance endpoint
    rds_host = 'pharmacy.cz2pnl3bqedl.us-east-1.rds.amazonaws.com'
    # Replace 'YOUR_RDS_USERNAME' and 'YOUR_RDS_PASSWORD' with your RDS credentials
    rds_username = 'postgres'
    rds_password = 'vpim7pCrFCOyXDFN8coj'
    # Replace 'YOUR_RDS_DATABASE_NAME' with your RDS database name
    rds_database = 'postgres'

    s3_client = boto3.client('s3')

    # Get the file object from the S3 bucket
    file_key = "pharmacy.csv"
    file_obj = s3_client.get_object(Bucket=s3_bucket_name, Key=file_key)

    # Read the CSV file data
    csv_data = file_obj['Body'].read().decode('utf-8').splitlines()

    logger.info("Connecting to the database")

    # Create a connection to the RDS database
    conn = db.connect(database=rds_database, user=rds_username, password=rds_password, host=rds_host)

    try:
        # Create a cursor object to execute SQL queries
        cursor = conn.cursor()

        # Parse the CSV data and insert into the database
        csv_reader = csv.reader(csv_data)
        next(csv_reader)  # Skip the header row if needed

        for row in csv_reader:
            # Replace 'YOUR_TABLE_NAME' with the actual table name in your RDS database
            sql = f"INSERT INTO pharmacy_entity (pharmacy_id, action_history, actions, active, last_action_date_time, store_number, system, system_version ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s)"
            cursor.execute(sql, (row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]))

        # Commit the changes to the database
        conn.commit()

        # Close the cursor and connection
        cursor.close()
        conn.close()

        return {
            'statusCode': 200,
            'body': 'Data saved in the database successfully.'
        }
    except Exception as e:
        logger.error(str(e))
        return {
            'statusCode': 500,
            'body': 'An error occurred while saving data to the database.'
        }


result =lambda_handler(None,None)
print(result)