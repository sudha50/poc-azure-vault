## Usage:

    mvn compile exec:java -Dexec.mainClass="com.keyvault.secrets.quickstart.App" -Dexec.args="<Id> <secretToRetrieve> <key-valult-name>"

Note:
<Id>  is  Azure Managed Identity  clientId
<secretToRetrieve> is name of the secret to retrieve from the vault
<key-valult-name> in our case it's **demo-vault-kti**