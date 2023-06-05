pipeline{
	agent any
	
	stages{
	stage('Compile Stage'){
	
	steps{
		withMaven(maven:'MyMaven'){
			sh 'mvn clean compile'
			}
		}
	}
	
	stage('Testing Stage'){
	
	steps{
		withMaven(maven:'MyMaven'){
			sh 'mvn test'
			}
		}
	}
	}
	post {
    always {
    	sh 'chmod +x /Users/dhvani/Desktop/BankingProject/cicd-script.sh'
        sh '/Users/dhvani/Desktop/BankingProject/cicd-script.sh'
    }
    failure {
                   publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'target/surefire-reports/', 
                       reportFiles: 'emailable-report.html', 
                       reportName: 'HTML Report', 
                       reportTitles: '', 
                       useWrapperFileDirectly: true])
                }
    
    
  }
}