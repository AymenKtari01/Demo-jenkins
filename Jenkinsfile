pipeline {
    agent any
    environment {
        SERVER_CREDENTIALS=credentials('Github-Credentials')
    }
    parameters{
        booleanParam(name='executeTests' , defaultValue=false , description='this parameter decides wether the tests will be executed or not ' ) 
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                echo "github credentials: ${SERVER_CREDENTIALS} "
                // Example: sh 'mvn clean package'
            }
        }
        stage('Test') {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                echo 'Testing...'
                // Example: sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Example: sh 'scp target/*.jar user@server:/path/to/deploy'
            }
        }
    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if the pipeline succeeds'
        }
        failure {
            echo 'This will run only if the pipeline fails'
        }
    }
}
