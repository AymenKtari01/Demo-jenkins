def buildApp() {
  echo 'Building...'
  echo "github credentials: ${SERVER_CREDENTIALS} "
}

def testApp() {
   echo 'Testing...'
}

def deployApp() {
    echo 'Deploying...'
    echo " deploying version : ${params.VERSION} " 
}

return this 
