pipeline {
    agent any
    environment {
        SERVER_CREDENTIALS=credentials('Github-Credentials')
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
