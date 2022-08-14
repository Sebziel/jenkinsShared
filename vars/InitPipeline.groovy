def call() {
    pipeline{
    agent any
    stages{
        stage('Params'){
            steps{
                parameters {
  extendedChoice bindings: '', groovyClasspath: '', groovyScript: 'return ["21.0.8","21.0.9"]', multiSelectDelimiter: ',', name: 'PLATFORM_VERSION', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_SINGLE_SELECT', visibleItemCount: 1
}
            }
        }
        stage('Playbook-sleep-test'){
            steps{
                sh "ansible-playbook -i /var/lib/jenkins/Ansible/inventory /var/lib/jenkins/Ansible/test-playbook.yaml --tags template -e build_number=${BUILD_NUMBER} -e pom_platform_version=${params.PLATFORM_VERSION} -e pom_appl_version=${params.EXTENSIONS_VERSION}"
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