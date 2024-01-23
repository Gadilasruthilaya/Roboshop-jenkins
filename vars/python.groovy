pipeline{

    agent { node { label 'workstation' }}


    stages{

        stage('unit test'){
            steps{
                // sh 'python -m unit test'
                echo 'unit test'
            }
        }
        stage('code analysis'){
            steps{
                echo 'code analysis'
                sh ' sonar-scanner -Dsonar.host.url=http://172.31.86.197:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=payment '
            }
        }

        stage('security scans'){
            steps{
                echo 'security scans'
            }
        }

        stage('artifact creation'){
            steps{
                echo 'artifact creation'
            }
        }
    }



}