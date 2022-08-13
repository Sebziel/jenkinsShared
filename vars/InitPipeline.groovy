def call() {
    pipeline{
    agent any
    stages{
        stage('Playbook-sleep-test'){
            steps{
                    script {
                        pom_platform_version = params.PLATFORM_VERSION
                        pom_appl_version = params.EXTENSIONS_VERSION
                    }
                sh "ansible-playbook -i /var/lib/jenkins/Ansible/inventory /var/lib/jenkins/Ansible/test-playbook.yaml --tags template -e build_number=${BUILD_NUMBER} -e pom_platform_version=$pom_platform_version -e pom_appl_version=${params.EXTENSIONS_VERSION}"
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