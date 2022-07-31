def call() {
    pipeline{
    agent any
    stages{
        stage('echo params'){
            steps{
                echo params.Environment
                echo params.nodes
                script{
                    ConfigureInstances = params.ConfigureInstances
                }
                echo ConfigureInstances
                echo params.RestartInstances.toString()
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