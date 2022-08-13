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
        stage('pingtest'){
            steps{
                sh 'ansible -i /var/lib/jenkins/Ansible/inventory -m ping ansibleSlave3'
            }
        }     
    }
}
}