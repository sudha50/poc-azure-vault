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
        String userAssignedclientId = args[0];
        String secretToRetrieve = args[1];
        String keyVaultName = args[2];
        if(userAssignedclientId == null || secretToRetrieve == null|| keyVaultName == null) {
            throw new RuntimeException("Please refer README.md for required args to be passed");
        }
        String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";


        DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder()
                .managedIdentityClientId(userAssignedclientId)
                .build();
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(defaultCredential)
                .buildClient();

        String password = secretClient.getSecret(secretToRetrieve).getValue();
        System.out.println("the retrieved password is : "+ password);

    }
}
