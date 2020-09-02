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
        stage('Save Artifact (.jar)') {
            steps {
                echo 'Saving artifacts..'
                archiveArtifacts 'target/*.jar'
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
