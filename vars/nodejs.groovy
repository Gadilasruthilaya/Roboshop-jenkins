def call(){

    pipeline{

        agent { node { label 'workstation' } }


        stages{

            stage('build'){
                steps{
                    sh 'npm install'
                    echo 'build'
                }
            }
            stage('unit test'){
                steps{
                    // sh 'npm test'
                    echo 'unit test'
                }
            }
            stage('code analysis'){
                steps{
                    echo 'sonar'
                    // sh 'sonar-scanner -Dsonar.host.url=http://172.31.86.197:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=cart'
                }
            }

            stage('security scans'){
                steps{
                    echo 'security scans'

                }
            }

            stage('artifact creation'){
                when{
                    expression{env.TAG_NAME ==~".*"}
                }
                steps{
                    echo 'artifact creation'
                    sh 'env'
                }
            }

        }
    }
}