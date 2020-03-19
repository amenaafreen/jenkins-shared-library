def call(){
    node {
        stage('Checkout') {
            checkout scm
        }
        stage('Package artifact') {
        def mvn_version = 'Maven'
        withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
        sh "mvn clean package"
    }
   }    
 }  
}
