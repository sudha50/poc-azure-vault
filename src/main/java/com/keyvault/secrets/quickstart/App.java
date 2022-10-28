package com.keyvault.secrets.quickstart;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

/**
 * Hello world!
 * https://learn.microsoft.com/en-us/azure/key-vault/secrets/quick-create-java?tabs=azure-cli
 *
 */
public class App {

    public static void main( String[] args ) {
        String keyVaultName = "demo-vault-kti";
        String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";
        String userAssignedclientId = args[0];
        DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder()
                .managedIdentityClientId(userAssignedclientId)
                .build();
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(defaultCredential)
                .buildClient();

        String password = secretClient.getSecret("password").getValue();
        System.out.println("the retrieved password is : "+ password);

    }
}
