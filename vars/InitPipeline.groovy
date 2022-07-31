def call() {
    pipeline{
    agent any
    stages{
        stage('echo params'){
            steps{
                echo params.nodes
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