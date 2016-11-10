node {
    stage('SCM') {
        git 'https://github.com/WinnieWong689/RMS.git'
    }
    stage('QA') {
        sh 'sonar-scanner'
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop rms || true"
        sh "docker rm rms || true"
        sh "docker run --name rms -p 11111:8080 -d tomcat"
        sh "docker cp target/rms.war rms:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
