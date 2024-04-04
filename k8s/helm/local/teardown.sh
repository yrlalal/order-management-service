echo "Teardown starting..."
order_management_service_released=$(helm list -o json | jq '.[] | select(.name == "order-management-service") | length > 0')
if [ "$order_management_service_released" = true ]; then
  echo "Uninstalling order-management-service:"
  helm uninstall order-management-service
  echo "Uninstalling order-management-service completed"
fi

postgres_released=$(helm list -o json | jq '.[] | select(.name == "ecommerce-postgres") | length > 0')
if [ "$postgres_released" = true ]; then
  echo "Uninstalling ecommerce-postgres release:"
  helm uninstall ecommerce-postgres
  echo "Uninstalling ecommerce-postgres completed."

  echo "Deleting postgres pvc:"
  kubectl delete pvc data-ecommerce-postgres-postgresql-0
  echo "Deleting postgres pvc completed"
else
  echo "ecommerce-postgres release doesn't exist."
fi

echo "Teardown completed."