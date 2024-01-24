def call() {
    node('workstation') {

         if (env.cibuild == "java") {
        stage('build') {
            sh 'mvn package'
            echo 'build'
        }
    }
            stage('unit test') {
                echo 'unit test'
                // sh 'npm test'
            }
            stage('code analysis') {
                echo 'code analysis'
               // sh 'sonar-scanner -Dsonar.host.url=http://172.31.86.197:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=frontend -Dsonar.qualitygate.wait=true'

            }

            stage('security scans') {
                echo 'security scans'
            }

           if (env.TAG_NAME == '.*')
            stage('artifact creation') {
                echo 'artifact creation'
            }
        }

    }
