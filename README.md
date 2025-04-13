# cipherOne - Spring Boot PII Detection Service

## Build Docker Image
```bash
docker build -t gcr.io/your-gcp-project-id/cipherone:latest .
```

## Push to Google Container Registry
```bash
gcloud auth configure-docker
docker push gcr.io/your-gcp-project-id/cipherone:latest
```

## Deploy to Google Cloud Run
```bash
gcloud run deploy cipherone   --image gcr.io/your-gcp-project-id/cipherone:latest   --platform managed   --region your-region   --allow-unauthenticated
```
