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
    	cucumber buildStatus: 'null', 
    	customCssFiles: '', 
   	 	customJsFiles: '', 
    	failedFeaturesNumber: -1, 
    	failedScenariosNumber: -1, 
    	failedStepsNumber: -1, 
    	fileIncludePattern: '**/*.json', 
    	pendingStepsNumber: -1, 
    	skippedStepsNumber: -1, 
    	sortingMethod: 'ALPHABETICAL', 
    	undefinedStepsNumber: -1
   
  }
  success {
    	sh 'chmod +x ./src/test/resources/cicdShellScript/cicd-script.sh'
        sh './src/test/resources/cicdShellScript/cicd-script.sh'
        }
   
    
  }
}