def call() {
    pipeline{
    agent any
    stages{
        stage('Playbook-sleep-test'){
            steps{
                sh "ansible-playbook -i /var/lib/jenkins/Ansible/inventory /var/lib/jenkins/Ansible/test-playbook.yaml" 
                echo "Current build number: ${BUILD_NUMBER}"
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