# Policy Management

## 1. Informations
- The project can be run with Java 17 and data is being recorded into H2 mock database. So, it is volatile.
- The easiest way to run the project is via IntelliJ. 
- Databse url=jdbc:h2:mem:testdb
- Username=sa
- Password=password

## 2. Endpoints And Sample Payloads via Curl

### 2.1. Policy Creation
```
curl --location --request POST 'localhost:8080/api/v1/policies' \
--header 'Content-Type: application/json' \
--data-raw '{
    "startDate": "15.07.2022",
    "insuredPersons": [
        {
            "firstName": "Jane",
            "secondName": "Johnson",
            "premium": 12.90
        },
        {
            "firstName": "Jack",
            "secondName": "Doe",
            "premium": 15.90
        }
    ]
}'
```
### 2.2. Policy Manipulation
```
curl --location --request POST 'localhost:8080/api/v1/policies/modification' \
--header 'Content-Type: application/json' \
--data-raw '{
    "policyId": 1,
    "effectiveDate": "12.09.2022",
    "insuredPersons": [
        {
            "firstName": "Jane",
            "secondName": "Johnson",
            "premium": 12.95
        },
        {
            "firstName": "Will",
            "secondName": "Smith",
            "premium": 12.90
        }
    ]
}'
```

### 2.3. Policy Information
```
curl --location --request GET 'localhost:8080/api/v1/policies' \
--header 'Content-Type: application/json' \
--data-raw '{
    "policyId": 1,
    "requestDate": "03.08.2022"
}'
```