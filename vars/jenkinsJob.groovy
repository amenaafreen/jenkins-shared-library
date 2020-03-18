def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("package")){
            packageArtifact()
        } else if(env.JOB_NAME.contains("test")) {
            buildAndTest()
        }
    }
}

def packageArtifact(){
    stage("Package artifact") {
        def mvn_version = 'M3'
withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
        sh "mvn clean package"
    }
}

def buildAndTest(){
    stage("Backend tests"){
     def mvn_version = 'M3'
withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] )
           sh "mvn clean test"
    }
}
