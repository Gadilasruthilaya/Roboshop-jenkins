pipeline{

    agent { node { label 'workstation' }}


    stages{

        stage('build'){
            steps{
                sh 'mvn package'
                echo 'build'
            }
        }
        stage('unit test'){
            steps{
                // sh 'mvn test'
                echo 'unit test'
            }
        }
        stage('code analysis'){
            steps{
                echo 'code analysis'
                sh ' sonar-scanner -Dsonar.host.url=http://172.31.86.197:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=shipping -Dsonar.java.binaries=target -Dsonar.qualitygate.wait=true'
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