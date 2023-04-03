import boto3

# Initialize an S3 client
s3 = boto3.client('s3')

# Specify the bucket name and file path
bucket_name = 'boto-s3-bucket-4'
file_path = 'D:/Development/aws/Boto3/aws-boto/Capture001.png'

# Upload the file to S3
fileUpload = s3.upload_file(file_path, bucket_name, 'remote/file/key')

print(fileUpload)
