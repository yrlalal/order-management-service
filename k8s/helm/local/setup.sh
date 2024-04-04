echo "Setup starting..."
helm repo add bitnami https://charts.bitnami.com/bitnami

echo "Installing ecommerce-postgres release"
helm install -f values_local.yaml ecommerce-postgres bitnami/postgresql --version 15.2.2 --atomic --dependency-update

echo "Installing order-management-service"
helm install order-management-service .
echo "Setup completed."