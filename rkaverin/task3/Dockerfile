FROM php:7.3-apache
COPY index.php /var/www/html/
RUN  sed -i 's/Listen 80/Listen 8080/g' /etc/apache2/ports.conf
CMD ["apache2-foreground"]