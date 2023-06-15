pipeline{
	agent any
	
stages {
    stage("verify tooling") {
      steps {
        sh '''
          docker version
          docker info
          docker compose version 
        '''
        }
    }
    
  
   stage('Clean running container') {
      steps {
        sh 'docker system prune -a --volumes -f'
      }
    }
    
    stage('Start container') {
        steps {
            retry(3){
             sh 'docker-compose -f docker-compose-v2.yml up --scale chrome=5 --scale firefox=5'
             sh 'docker compose ps'
            }
            timeout(time: 5, unit: 'MINUTES') {
                    echo 'timeout'
                }
           

            }
        }
    
    
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
    	jsonReportDirectory: 'target',
    	pendingStepsNumber: -1, 
    	skippedStepsNumber: -1, 
    	sortingMethod: 'ALPHABETICAL', 
    	undefinedStepsNumber: -1
   
  }
  failure {
    	sh 'chmod +x ./src/test/resources/cicdShellScript/cicd-script.sh'
        sh './src/test/resources/cicdShellScript/cicd-script.sh'
        }
   
  }
  }
