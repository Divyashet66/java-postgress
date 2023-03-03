pipeline {
  agent any

	tools {
		 maven 'Maven'
	}
	environment {
		        PROJECT_ID = "tech-rnd-project"
				CLUSTER_NAME = "network18-cluster"
				LOCATION = "us-central1-a"
				CREDENTIALS_ID = "kubernetes"		
	}
	
    stages {
	    stage('Scm Checkout') {
		    steps {
			    	checkout scm
		    }
	    }
	    
	    stage('Build'){

            steps{

                sh 'mvn clean'
            }

       }
	    
	    stage('Test'){

            steps{

                sh 'mvn test'
            }

       }

       

	    stage('Build Docker Image') {
		    steps {
			    sh 'whoami'
			    sh 'sudo chmod 777 /var/run/docker.sock'
			    
			    sh 'sudo apt update'
 			    sh 'sudo apt install software-properties-common'
			    sh 'sudo add-apt-repository ppa:cncf-buildpacks/pack-cli'
			    
 				sh 'sudo  apt-get update'
 				sh 'sudo apt-get install pack-cli'
			   
			    sh 'pack build java-postgress --builder paketobuildpacks/builder:full'
				sh 'docker tag java-postgress gcr.io/tech-rnd-project/java-postgress'
			    
		    }
	    }
	    
	    stage("Push Docker Image") {
		    steps {
			    script {
				echo "Push Docker Image"
				sh 'gcloud auth configure-docker'
				sh "sudo docker push gcr.io/tech-rnd-project/java-postgress"
				
				
				    
			    }
		    }
	    }
	    
	    stage('Deploy to K8s') {
		    steps{
			    echo "Deployment started ..."
			    sh 'ls -ltr'
			    sh 'pwd'
				
				echo "Start deployment of deployment.yaml"
				step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'deployment-k8', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
			    	echo "Deployment Finished ..."
			    sh '''
			    '''
			    
		    }
	    }
	 
    }
	
}
