pipeline {
  environment {
    registry = "yoksar/tracking-service"
    registryCredential = 'dockerhub'
    dockerImage = ''
    gitUrl = 'https://github.com/proftaak-s6/tracking-service.git'
  }
  agent any
    stages {
        stage('Cloning Git') {
            steps {
                git([url: gitUrl, branch: 'master', credentialsId: 'Github'])
            }
        }
        stage('Building image') {
            steps{
                script {
                dockerImage = docker.build registry
                }
            }
        }
        stage('Deploy Image') {
            steps{
                    script {
                        docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Remove Unused docker image') {
            steps{
                sh "docker rmi $registry"
            }
        }


        stage("Production") {
            steps{
                node("docker-prod"){
                    git([url: gitUrl, branch: 'master', credentialsId: 'Github'])
                    // sh "docker service rm tracking-service_tracking"
                    sh "docker stack deploy --with-registry-auth -c docker-compose.prod.yml tracking-service"
                }
            }
        }
    }
}