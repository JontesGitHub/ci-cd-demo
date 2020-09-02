pipeline {
    //agent {
      //  docker { image 'maven:3.6.3-slim' }
    //}
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                //sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                //sh 'mvn test'
            }
            //post {
               // always {
               //     junit 'target/surefire-reports/*.xml'
               // }
           // }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
                sh 'mvn package -Dmaven.test.skip=true && java -jar target/ci-cd-demo-SNAPSHOT.jar'
            }
            post {
                always {
                    echo 'Saving artifacts..'
                    //archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
                }
            }
        }
    }
}
