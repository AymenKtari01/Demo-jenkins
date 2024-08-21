def gv 
pipeline {
    agent any
    environment {
        SERVER_CREDENTIALS=credentials('Github-Credentials')
    }
    parameters{
        choice(name :'VERSION' , choices : ['1.0.0' , '1.0.1' , '1.1.0' , '2.0.1' ] , description : 'choose the version to be deployed ' ) 
        booleanParam(name: 'executeTests' , defaultValue: true , description: 'this parameter decides wether the tests will be executed or not ' ) 
    }
    stages {
        stage('Init') {
            steps {
                script{
                    gv=load('script.groovy')
                }
            }
        }
        stage('Build') {
            steps {
                script{
                    gv.buildApp()
                }
            }
        }
        stage('Test') {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script{
                    gv.testApp()
                }
            }
        }

        
        stage('Deploy') {
            input{
                message " Select the environment to deploy to " 
                ok " Done " 
                parameters {
                    choice(name :'ENV' , choices : ['dev' , 'Staging' , 'prod' ] , description : '' ) 
                }
            }
            steps {
                script{
                    gv.deployApp()
                }
                echo " the selected environment to deploy to is ${ENV} " 
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
