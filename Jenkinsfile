pipeline {
    agent any
        environment { SONARQUBE = 'SonarQube' } // must match Jenkins Configure System name

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/udamale/student-app-maven.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project and create the .class files
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Sonar Analysis') {
      steps {
        withSonarQubeEnv("${SONARQUBE}") {
          sh 'mvn -B sonar:sonar'
        }
      }
    }

    stage('Quality Gate') {
      steps {
        timeout(time: 5, unit: 'MINUTES') {
          script {
            def qg = waitForQualityGate()
            echo "Quality Gate: ${qg.status}"
            if (qg.status != 'OK') { error "Pipeline stopped: Quality Gate = ${qg.status}" }
          }
        }
      }
    }
     stage('maven') {
            steps {
              
                  sh 'mvn package'
                }

        }
      stage('tomcat') {
            steps {
             deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'shh11', path: '', url: 'http://13.126.137.71:8081/')], contextPath: 'webapp', war: '*/*.war'
             }
       }

    }

    post {
        success {
            echo '✅ Build + Sonar OK'
        }
        failure {
            echo '❌ Pipeline failed: see console output or SonarQube results'
        }
    }
}
