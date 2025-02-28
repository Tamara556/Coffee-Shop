FROM postgres:latest

# Set environment variables for PostgreSQL
ENV POSTGRES_USER=postgres \
    POSTGRES_PASSWORD=root \
    POSTGRES_DB=cofee_shop

# Expose the default PostgreSQL port
EXPOSE 5432

# Use the official entry point
CMD ["postgres"]
