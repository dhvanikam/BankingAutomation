pipeline {
    agent any  
    stages {
        
         
        

        stage('Testing Stage') {
            parallel {
                stage('Test with chrome') {
                    steps {
                        withMaven(maven:'MyMaven') {
                            sh 'mvn test -Dbrowser=chrome -Dallure.results.directory=./target/chrome/allure-results'
                        }
                    }
                }

                stage('Test with firefox') {
                    steps {
                        withMaven(maven:'MyMaven') {
                            sh ' mvn test -Dbrowser=firefox -Dallure.results.directory=./target/firefox/allure-results'
                        }
                    }
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
        fileIncludePattern: 'Report.json',
        jsonReportDirectory: 'target',
        pendingStepsNumber: -1,
        skippedStepsNumber: -1,
        sortingMethod: 'ALPHABETICAL',
        undefinedStepsNumber: -1

            allure([includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [
                            [path: 'target/chrome/allure-results'],
                            [path: 'target/firefox/allure-results']
                        ]
                    ])
            sh 'docker compose -f docker-compose-v2.yml down --remove-orphans -v'
            
        }
    }
}
