## Usage:

    mvn compile exec:java -Dexec.mainClass="com.keyvault.secrets.quickstart.App" -Dexec.args="<Id> <secretToRetrieve> <key-vault-name>"
    
  Note: 

 1.  Id -  is  Azure user Managed Identity  clientId 
 2. secretToRetrieve  - is name of the secret to retrieve from the vaul
 3.  key-vault-name - in my  case it's **demo-vault-kti**
