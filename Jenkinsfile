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
            retry(2){
             sh 'docker-compose -f docker-compose-v2.yml up -d --scale chrome=2 --scale firefox=2'
             sh 'docker compose -f docker-compose-v2.yml ps'
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
  success {
    	sh 'chmod +x ./src/test/resources/cicdShellScript/cicd-script.sh'
        sh './src/test/resources/cicdShellScript/cicd-script.sh'
        }
   
  }
  }
