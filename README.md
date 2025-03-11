# Spring Boot & Azure Key Vault Integration - Quick Setup

This project retrieves secrets from Azure Key Vault in a Spring Boot app, avoiding hardcoded secrets.
There is a single endpoint `/api/v1/message` that returns a secret from Azure Key Vault.

## Steps

1.  **Key Vault:** Create a Key Vault and add your secret.
2.  **Dependency:** Add `spring-cloud-azure-starter-keyvault-secrets` and `azure-identity` to your `pom.xml`.
3.  **`application.yml`:** Set `spring.cloud.azure.keyvault.secret.property-sources[0].endpoint` to your Key Vault URL.  Use a property (e.g., `secret.message: ${yourSecretName}`) to reference the secret.
4. **Managed Identity:** Enable Managed Identity for your app in Azure.
5. **Permissions:** Give your app the right roles to access the Key Vault from the Key Vault's Access Control (IAM)
5. **Secret Usage:** Use `${yourSecretName}` in your code to access the secret.
6. **Run:** Start your Spring Boot app and it will fetch the secret from Azure Key Vault. (Make sure to be authenticated to Azure, e.g., via `az login` when running locally)