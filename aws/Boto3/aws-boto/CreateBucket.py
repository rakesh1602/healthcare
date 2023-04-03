import boto3

# Initialize an S3 client with the us-east-1 endpoint URL
s3 = boto3.client('s3', endpoint_url='https://s3.amazonaws.com')

# Specify the bucket name
bucket_name = 'boto-s3-bucket-4'

# Create the S3 bucket with a custom ACL
s3.create_bucket(
    Bucket=bucket_name,
    ACL='private'
)

print(bucket_name)
