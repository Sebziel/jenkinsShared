def call() {
    pipeline{
    agent any
    stages{
        stage('Stage1'){
            steps{
                sh 'echo echoing from stage 1 of InitPipeline'
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