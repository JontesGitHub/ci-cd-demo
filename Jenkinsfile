pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                //mvn clean compile
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                //mvn test
            }
        }
        stage('Publish Tests') {
            steps{
                echo 'publishing tests..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
                //mvn package -Dmaven.test.skip=true && java -jar target/ci-cd-demo-SNAPSHOT.jar
            }
        }
    }
}