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
                echo 'Publishing tests..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
                //mvn package -Dmaven.test.skip=true && java -jar target/ci-cd-demo-SNAPSHOT.jar
            }
        }
        post {
            always {
                echo 'Saving artifacts..'
                archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
            }
        }
    }
}
