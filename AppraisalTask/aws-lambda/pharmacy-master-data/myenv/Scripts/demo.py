
import psycopg2


def lambda_handler(event, context):
    # Replace the following placeholders with your PostgreSQL connection details
    host = 'localhost'
    port = '5432'
    database = 'postgres'
    user = 'postgres'
    password = 'postgres'

    # Establish a connection to the PostgreSQL database
    conn = psycopg2.connect(
        host=host,
        port=port,
        database=database,
        user=user,
        password=password
    )

    try:
        # Create a cursor object to execute SQL queries
        cursor = conn.cursor()

        # Execute a sample SQL query
        cursor.execute('SELECT * FROM pharmacy_entity')

        # Fetch all rows from the result set
        rows = cursor.fetchall()

        # Print the retrieved rows
        for row in rows:
            print(row)

        # Close the cursor and connection
        cursor.close()
        conn.close()

        return {
            'statusCode': 200,
            'body': 'Successfully connected to the PostgreSQL database.'
        }
    except Exception as e:
        return {
            'statusCode': 500,
            'body': str(e)
        }


# Call the lambda_handler function directly
result = lambda_handler(None, None)
print(result)
