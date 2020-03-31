FROM adtiming/omjava
MAINTAINER openmediation
ENV SYSTEMNAME "omsystem"
ENV SERVERNAME "om-ds-server"
RUN mkdir ${SERVERNAME} 
ADD docker-entrypoint.sh /
ADD application-loc.yml /${SERVERNAME}/
ADD om-ds-server.jar /${SERVERNAME}/
WORKDIR /
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:19013/api/check || exit 1
EXPOSE 19013
ENTRYPOINT ["/docker-entrypoint.sh"] 
CMD ["om-ds-server"]
