#include <unistd.h>
#include <stdio.h>
#include "write_all.h"

bool write_all(int fd, char *buffer, int count) {
  while(count>0) {
    int w=write(fd,buffer,count);
    if (w<0) {
      perror("write");
      return false;
    }
    count-=w;
    buffer+=w;
  }
  return true;
}
