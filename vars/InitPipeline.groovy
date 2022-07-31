def call() {
    pipeline{
    agent any
    stages{
        stage('echo params'){
            steps{
                echo params.Environment
                echo params.nodes
                script{
                    String ConfigureInstances = String.valueOf(params.ConfigureInstances)
                }
                echo ConfigureInstances
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