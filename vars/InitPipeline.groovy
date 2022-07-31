def call() {
    pipeline{
    agent any
    stages{
        stage('echo params'){
            steps{
                echo params.Environment
                echo params.nodes
                echo params.ConfigureInstances
                echo params.RestartInstances
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