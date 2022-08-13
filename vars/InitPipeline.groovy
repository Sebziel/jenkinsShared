def call() {
    pipeline{
    agent any
    stages{
        stage('echo params'){
            steps{
                echo "ConfigureInstances: variable" 
                echo "RestartInstances: variable" 
            }
        }
        stage('stage2'){
            steps{
                sh 'echo echoing from stage 2 of InitPipeline'
            }
        }     
    }
}
}