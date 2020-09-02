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
                sh 'pwd'
                sh 'ls'
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
                //sh 'mvn package -Dmaven.test.skip=true && java -jar target/ci-cd-demo-SNAPSHOT.jar'
                sh 'mvn clean install && sudo java -jar /var/lib/jenkins/.m2/repository/jontes/io/ci-cd-demo/0.0.1-SNAPSHOT/ci-cd-demo-0.0.1-SNAPSHOT.jar'
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
